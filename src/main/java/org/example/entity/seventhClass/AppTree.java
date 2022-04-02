package org.example.entity.seventhClass;

import org.example.entity.seventhClass.Util.HibernateUtil7;
import org.example.entity.sixthClass.Util6.HibernateUtil6;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;


public class AppTree {
    public static void main(String[] args) {

//        HibernateUtil7.getSessionFactory();
//        Tree tree = new Tree(1400,"Gingko tree","Zhongnan Mountains","China");
//        Tree tree = new Tree(125,"Old Rhododendron","Quebec","Canada");
//        Tree tree = new Tree(3200,"Baobab trees","the road between Morondava and Belon’i Tsiribihina","Madagascar");
        Tree tree = new Tree(1000,"Japanese Maple","Portland","Oregon");

//            create(tree);
//        getById(3);
//        for (Tree t:
//             read()) {
//            System.out.println(t +"\n");
//        }
//        update(5,"Baobab");
//        delete(1);
//        deleteAll();
    }

    public static void create(Tree tree){
        try(Session session = HibernateUtil7.getSessionFactory().openSession()){
            session.beginTransaction();
           session.save(tree);
           session.getTransaction().commit();
            System.out.println("Created...\n" + tree);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getById(int id){
        try(Session session =HibernateUtil7.getSessionFactory().openSession()){
            session.beginTransaction();
            Tree tree=session.get(Tree.class,id);
            session.getTransaction().commit();
            System.out.println("Got id--- " +tree.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Tree> read(){
        List<Tree> trees= null;
        try(Session session =HibernateUtil7.getSessionFactory().openSession()){
            session.beginTransaction();
            trees=session.createQuery("from Tree ").getResultList();
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        return trees;
    }

    public static void update(int id,String name){
        try(Session session = HibernateUtil7.getSessionFactory().openSession()){
            session.beginTransaction();
            Tree tree=session.get(Tree.class,id);
            tree.setName(name);
            session.update(tree);
            session.getTransaction().commit();
            System.out.println("Updated id "+tree.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id){
        try(Session session =HibernateUtil7.getSessionFactory().openSession()){
            session.beginTransaction();
            Tree tree=session.get(Tree.class,id);
            session.delete(tree);
            session.getTransaction().commit();
            System.out.println("Deleted id " +tree.getId() + " from table");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAll(){
        try(Session session = HibernateUtil7.getSessionFactory().openSession()){
            session.beginTransaction();
            Query query =session.createQuery("delete from Tree ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Deleted...");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
