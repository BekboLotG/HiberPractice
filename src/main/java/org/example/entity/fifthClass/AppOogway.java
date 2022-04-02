package org.example.entity.fifthClass;

import org.example.entity.fifthClass.Util5.HibernateUtil5;
import org.example.entity.fourthClass.Util4.HibernateUtil4;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class AppOogway {
    public static void main(String[] args) {
//        HibernateUtil5.getSessionFactory();

//        OogwayStudents oogwayStudents = new OogwayStudents("Shifu","Red panda","blue","Orange-brown robe;black pants",'M',60,"Jade Palace in the Valley of Peace");
//        OogwayStudents oogwayStudents = new OogwayStudents("Snow Leopard","Snow Leopard","blue","Blue vest, white leg wraps, brown gloves, pants, and cuirass",'F',60,"Unspecified");
//        OogwayStudents oogwayStudents = new OogwayStudents("Wushen","Frog","black","Dark brown robe with white leg and wrist wraps",'M',50,"Jade Palace");
        OogwayStudents oogwayStudents = new OogwayStudents("Chao","Lizard","yellow","Red cloak, Red violet belt and Light Green Pants",'M',80,"Onyx Temple");

//        createTable(oogwayStudents);
//        System.out.println(getAll());
//        System.out.println(getById(2));
//        update(2,"Shy-fu");
//        delete(1);
        deleteAllDates();
    }

    public  static int createTable(OogwayStudents oogwayStudents){
        try(Session session= HibernateUtil5.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(oogwayStudents);
            session.getTransaction().commit();
            System.out.println("Successfully ");
        }catch (Exception e){
            e.printStackTrace();
        }
        return oogwayStudents.getId();
    }

    public static List<OogwayStudents> getAll(){
        List<OogwayStudents> oogwayStudents=null;
        try(Session session=HibernateUtil5.getSessionFactory().openSession()){
            session.beginTransaction();
            oogwayStudents=session.createQuery("from OogwayStudents ").getResultList();
            session.getTransaction().commit();
            System.out.println(oogwayStudents.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        return oogwayStudents;
    }

    public static void update(int id,String name){
        try(Session session=HibernateUtil5.getSessionFactory().openSession()){
            session.beginTransaction();
            OogwayStudents oogwayStudents =session.get(OogwayStudents.class,id);
            oogwayStudents.setName(name);
            session.update(oogwayStudents);
            session.getTransaction().commit();
            System.out.println("Успешно обновлено!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static OogwayStudents getById(int id){
        OogwayStudents oogwayStudents=null;

        try(Session session=HibernateUtil5.getSessionFactory().openSession()){
            session.beginTransaction();
            oogwayStudents=session.get(OogwayStudents.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return oogwayStudents;
    }

    public static void delete(int id) {
        try {
            Session session = HibernateUtil5.getSessionFactory().openSession();
            session.beginTransaction();
            OogwayStudents oogwayStudents = session.get(OogwayStudents.class, id);
            session.delete(oogwayStudents);
            session.getTransaction().commit();
            session.close();
            System.out.println(" Удален мастер кун-фу- " + oogwayStudents.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllDates() {
        try {
            Session session = HibernateUtil5.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from OogwayStudents ");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Deleted successfully Oogway's students... ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
