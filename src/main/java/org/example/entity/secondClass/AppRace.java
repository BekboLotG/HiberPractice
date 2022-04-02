package org.example.entity.secondClass;

import org.example.entity.secondClass.Util2.HibernateUtil2;
import org.hibernate.Session;


import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class AppRace {
    public static void main(String[] args) {

//       HibernateUtil2.getSessionFactory();
//        SugarRushRaces races = new SugarRushRaces("Vanellope Von Cupcake","Princess Vanellope",
//                10,"having fun with Ralph","Sweet Fast & Furious","Turbo", LocalDate.of(2012,12,12));
//
//        SugarRushRaces races = new SugarRushRaces("Rancis Fluggerbutter","Butterfingers",
//                5,"winning races","Sugar Rush"," losing races", LocalDate.of(2018,1,1));

        SugarRushRaces races = new SugarRushRaces("CandleHead","Minty Zaki",
                7,"her candle","Litwak's Arcade","glitches", LocalDate.of(2015,7,22));
//        create(races);
//        System.out.println(getById(1));
//        for (SugarRushRaces s:readRacer()) {
//            System.out.println("\n "+s);
//        }
//         update(2,"surprises");
//           delete(1);
           deleteAll();


    }


    public static int create(SugarRushRaces races){
       try(Session session = HibernateUtil2.getSessionFactory().openSession()){
           session.beginTransaction();
           session.save(races);
           session.getTransaction().commit();
           System.out.println(races.getSecondName()+" added");
       }catch (Exception e){
           e.printStackTrace();
       }
       return races.getId();
    }

    public static SugarRushRaces getById(int id){
        SugarRushRaces sugarRushRaces = null;
        try(Session session = HibernateUtil2.getSessionFactory().openSession()){
            session.beginTransaction();
            sugarRushRaces=session.get(SugarRushRaces.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        return sugarRushRaces;
    }

    public static List<SugarRushRaces> readRacer(){
        List<SugarRushRaces> sugarRushRaces= null;
        try(Session session =
                HibernateUtil2.getSessionFactory().openSession()){
            session.beginTransaction();
            sugarRushRaces =session.createQuery("from SugarRushRaces ").getResultList();
            session.getTransaction().commit();
            System.out.println("Found- " +sugarRushRaces.size() + " racers");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sugarRushRaces;
    }

    public static void update(int id,String hobbies){

        try(Session session=
                HibernateUtil2.getSessionFactory().openSession()){
            session.beginTransaction();
            SugarRushRaces sugarRushRaces=session.get(SugarRushRaces.class,id);
            sugarRushRaces.setHobbies(hobbies);
            session.update(sugarRushRaces);
            session.getTransaction().commit();
            System.out.println("Successfully updated");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id){
        try(Session session=
                HibernateUtil2.getSessionFactory().openSession()){
            session.beginTransaction();
            SugarRushRaces sugarRushRaces= session.get(SugarRushRaces.class,id);
            session.delete(sugarRushRaces);
            session.getTransaction().commit();
            System.out.println("Deleted " +sugarRushRaces.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteAll(){
        try(Session session =
                HibernateUtil2.getSessionFactory().openSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from SugarRushRaces ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Successfully deleted all dates from sugar_rushes's table");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
