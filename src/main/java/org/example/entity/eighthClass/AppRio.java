package org.example.entity.eighthClass;


import org.example.entity.eighthClass.util8.HibernateUtil8;
import org.example.entity.secondClass.SugarRushRaces;
import org.example.entity.secondClass.Util2.HibernateUtil2;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AppRio {
    public static void main(String[] args) {

//        HibernateUtil8.getSessionFactory();

//        Rio rio = new Rio("Blu","Голубчик","Spix's Macaw","Not knowing how to fly","\t\"I can't fly!\"");
//        Rio rio = new Rio("Jewel","Жемчужинка","Spix's Macaw","Losing her family and friends","\t\"Quem é você? Quê que você está fazendo aqui?\"");
//        Rio rio = new Rio("Linda","Tree-hugger","Human","Big Boss","\t\"Cheese and sprinkles!\"");
        Rio rio = new Rio("Nico","Nico","Yellow Canary","-","\t\"Brazilian ladies respond to confidence!\"");

//        create(rio);
//        System.out.println(getById(3));
//        update(6,"Linda","Nothing");
//        readRio();
//        delete(2);
        deleteAll();


    }

    public static int create(Rio rio){
        try(Session session = HibernateUtil8.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(rio);
            session.getTransaction().commit();
            System.out.println("id= "+ rio.getId() +"\n"+ rio.getNickname()+ " added");
        }catch (Exception e){
            e.printStackTrace();
        }
        return rio.getId();
    }

    public static Rio getById(int id){
        Rio rio = null;
        try(Session session = HibernateUtil8.getSessionFactory().openSession()){
            session.beginTransaction();
            rio=session.get(Rio.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        return rio;
    }

    public static List<Rio> readRio(){
        List<Rio> rios= null;
        try(Session session =
                    HibernateUtil8.getSessionFactory().openSession()){
            session.beginTransaction();
            rios =session.createQuery("from Rio ").getResultList();
            session.getTransaction().commit();
            System.out.println("Found- " +rios.size());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return rios;
    }

    public static void update(int id,String nickName,String dislike){

        try(Session session=
                    HibernateUtil8.getSessionFactory().openSession()){
            session.beginTransaction();
           Rio rio=session.get(Rio.class,id);
            rio.setDislike(dislike);
            rio.setNickname(nickName);
            session.update(rio);
            session.getTransaction().commit();
            System.out.println("Successfully updated");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id){
        try(Session session=
                    HibernateUtil8.getSessionFactory().openSession()){
            session.beginTransaction();
            Rio rio=session.get(Rio.class,id);
            session.delete(rio);
            session.getTransaction().commit();
            System.out.println("Deleted " +rio.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteAll(){
        try(Session session =
                    HibernateUtil8.getSessionFactory().openSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from Rio ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Successfully deleted all dates from rio's table");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
