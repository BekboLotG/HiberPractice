package org.example.entity.ninethClass;

import org.example.entity.fristClass.util.HibernateUtil;
import org.example.entity.ninethClass.util9.HibernateUtil9;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class AppMountain {
    public static void main(String[] args) {

        HibernateUtil9.getSessionFactory();
        Mountain mountain= new Mountain("Mount Everest","Himalayas","China",8848.86,8848.86);
//        Mountain mountain= new Mountain("Aconcagua","Andes","Argentina",6960.8,6960.8);
//        Mountain mountain= new Mountain("Vinson Massif","Sentinel Range","Antarctica",8848.86,8848.86);
//        Mountain mountain= new Mountain("Puncak Jaya","Sudirman Range"," Indonesia",4884.00,4884.00);
//        Mountain mountain= new Mountain("Mauna Kea","Hawaii,","United States",4205.00,4205.00);

//        create(mountain);
//        System.out.println(getById(1));
//        for (Mountain m:read()) {
//            System.out.println(m);
//        }
//        update(5,"Hawaiian Islands");
//        delete(5);
         deleteAll();



    }



    public static void create(Mountain mountain){

        try(Session session = HibernateUtil9
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            session.save(mountain);
            session.getTransaction().commit();
            System.out.println("Successfully added \n"+ mountain);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Mountain getById(int id) {
        Mountain mountain = null;
        try (Session session = HibernateUtil9
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            mountain = session.get(Mountain.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mountain;
    }

    public static List<Mountain> read() {
        List<Mountain> mountains = null;
        try (Session session = HibernateUtil9
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            mountains = session.createQuery("from Mountain ").getResultList();
            session.getTransaction().commit();
            System.out.println("Found " + mountains.size() +" mountains");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mountains;
    }

    public static void update(int id,String mountain){
        try(Session session = HibernateUtil9
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
          Mountain mountains=session.get(Mountain.class,id);
           mountains.setMountain(mountain);
            session.update(mountains);
            session.getTransaction().commit();
            System.out.println("Successfully updated: "+ " id  " +mountains.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id){
        try(Session session = HibernateUtil9
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Mountain mountain=session.get(Mountain.class,id);
            session.delete(mountain);
            session.getTransaction().commit();
            System.out.println(mountain.getPeak() +" is deleted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void  deleteAll(){
        try(Session session=HibernateUtil9
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from Mountain");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Deleted all dates from Mountain...");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
