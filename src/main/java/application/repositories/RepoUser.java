package application.repositories;

import application.Entities.User;
import application.controllers.ServerException;
import application.interfaces.IRepoUser;
import application.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


/*
This is a repository used to manage the login/register functionalities
 */
@Component
public class RepoUser implements IRepoUser {
    SessionFactory sessionFactory;

    public RepoUser() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    /*
    If username or email already exist in database, throws ServerException
    Otherwise, save the User entity
    Used for register
     */
    @Override
    public int addUser(User a) throws ServerException {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer userID = null;

        try {
            tx = session.beginTransaction();

            boolean emailExist = this.findByEmail(a.getEmail());
            boolean usernameExist = this.findByUsername(a.getUsername());

            if(emailExist)
                throw new ServerException("This email is used!");
            if(usernameExist)
                throw new ServerException("This username is used!");

            userID = (Integer) session.save(a);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }

    /*
    Used to search if database already contains a user with this username
     */
    @Override
    public boolean findByUsername(String username) {
        User found = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                found = session.createQuery("from User where username=:username", User.class).setParameter("username", username)
                        .setMaxResults(1)
                        .uniqueResult();
                tx.commit();
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        if (found == null)
            return false;
        return true;
    }

    /*
    Used to search if database already contains a user with this email
     */
    @Override
    public boolean findByEmail(String email) {
        User found = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                found = session.createQuery("from User where email=:email", User.class).setParameter("email", email)
                        .setMaxResults(1)
                        .uniqueResult();
                tx.commit();
            } catch (RuntimeException ex) {
                if (tx != null)
                    tx.rollback();
            }
        }
        if (found == null)
            return false;
        return true;
    }


/*
Check if the given user corespond to an entity in the database
Throws ServerException if not
Used for login
 */
    @Override
    public User findUser(User user) {
        User found = null;
        try(Session session = sessionFactory.openSession()){
            Transaction tx=null;
            try{
                tx = session.beginTransaction();
                found = session.createQuery("from User where username=:username and password=:password",User.class)
                        .setParameter("username",user.getUsername())
                        .setParameter("password",user.getPassword())
                        .setMaxResults(1)
                        .uniqueResult();
                tx.commit();
            } catch(RuntimeException ex){
                if (tx!=null)
                    tx.rollback();
            }
        }

        if(found == null)
            throw new ServerException("Username or password incorrect!");
        return found;
    }

}
