package org.example.entity.fourthClass;

import org.example.entity.fourthClass.Util4.HibernateUtil4;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AppCoco {
    public static void main(String[] args) {
//        HibernateUtil4.getSessionFactory();
        Coco coco=new Coco(" Miguel","Rivera","Un Poco Loco","¡Ay, mi amor! ¡Ay, mi amor!",true,"Santa Cecilia");
//        Coco coco=new Coco("Héctor","Rivera","Remember me","¡Until you're in my arms again\n Remember me!",false,"Land of the Dead");
//        save(coco);
//        System.out.println(getById(1));
//        update(1,"Remember me!!!!");
//        getAllCoco();
//        delete(2);
//        deleteAll();
    }

    public static int save(Coco coco){

        try(Session session = HibernateUtil4
                .getSessionFactory()
                .openSession()){
            session.beginTransaction();
            session.save(coco);
            session.getTransaction().commit();
            System.out.println("Successfully added "+ coco.getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return coco.getId();
    }

    public static Coco getById(int id) {
        Coco coco = null;
        try (Session session = HibernateUtil4
                .getSessionFactory()
                .openSession()) {
            session.beginTransaction();
            coco=session.get(Coco.class,id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coco;
    }

    public static void update(int id,String music){
        try(Session session=
                HibernateUtil4.getSessionFactory().openSession()){
            session.beginTransaction();
            Coco coco = session.get(Coco.class,id);
            coco.setMusic(music);
            session.update(coco);
            session.getTransaction().commit();
            System.out.println("Updated!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Coco> getAllCoco(){
        List<Coco> cocos=null;
        try(Session session=
                HibernateUtil4.getSessionFactory().openSession()){
            session.beginTransaction();
            cocos=session.createQuery("from Coco ").getResultList();
            session.getTransaction().commit();
            System.out.println("Found --- " +cocos.size()+" Coco's inhabitants"+ "\n"+cocos);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cocos;
    }

    public static void delete(int id){
        try(Session session=
                HibernateUtil4.getSessionFactory().openSession()){
            session.beginTransaction();
            Coco coco =session.get(Coco.class,id);
            session.delete(coco);
            session.getTransaction().commit();
            System.out.println("Operation successfully done");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteAll(){
        try(Session session=
                HibernateUtil4.getSessionFactory().openSession()){
            session.beginTransaction();
            Query query =session.createQuery("delete from Coco ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("All deleted...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
