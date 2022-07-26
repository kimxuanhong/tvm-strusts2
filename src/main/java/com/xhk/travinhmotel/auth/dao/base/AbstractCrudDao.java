package com.xhk.travinhmotel.auth.dao.base;

import com.xhk.travinhmotel.auth.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public abstract class AbstractCrudDao<T, ID> implements CrudDao<T, ID> {

    @SuppressWarnings("unchecked")
    public Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the  object
            session.save(entity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the  object
            session.update(entity);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a entity object
            if (entity != null) {
                session.delete(entity);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(ID id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getInstance().getSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a entity object
            T entity = session.get(getClazz(), (Serializable) id);
            if (entity != null) {
                session.delete(entity);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        Transaction transaction = null;
        T result = null;

        try (Session session = HibernateUtil.getInstance().getSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an result object
            result = session.get(getClazz(), (Serializable) id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return Optional.ofNullable(result);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        Transaction transaction = null;
        List<T> resultList = new ArrayList<>();
        try (Session session = HibernateUtil.getInstance().getSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an entity object

            resultList = session.createQuery(String.format("FROM %s", getClazz().getSimpleName())).getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return resultList;
    }

    protected Optional<T> fetchOne(String queryString, Map<String, Object> params) {
        try (Session session = HibernateUtil.getInstance().getSession()) {
            Query<T> query = session.createQuery(queryString, getClazz());
            this.mappingParams(query, params);

            return Optional.of(query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    protected List<T> fetch(String queryString, Map<String, Object> params) {
        try (Session session = HibernateUtil.getInstance().getSession()) {
            Query<T> query = session.createQuery(queryString, getClazz());
            this.mappingParams(query, params);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    protected void mappingParams(Query<T> query, Map<String, Object> params) {
        Set<String> keys = params.keySet();
        for (String key : keys) {
            query.setParameter(key, params.get(key));
        }
    }
}
