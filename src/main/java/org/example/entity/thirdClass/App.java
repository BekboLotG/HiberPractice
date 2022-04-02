package org.example.entity.thirdClass;


import org.example.entity.thirdClass.util3.HibernateUtil3;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
//      HibernateUtil3.getSessionFactory();

//        NYC_Zoo nycZoo = new NYC_Zoo("Закари Алакай","Алекс","Макунгу","голубой",'М',"Лев");
//        NYC_Zoo nycZoo = new NYC_Zoo("Кристофер Марти","Марти","-","зеленый",'М', "Зебра");

//        NYC_Zoo nycZoo = new NYC_Zoo("Глория","Бегемотиха","кабан Вилбур","карие",'Ж', "Бегемот");
//        NYC_Zoo nycZoo = new NYC_Zoo("Мелман Манкевич","Мелман","Мото-Мото","ореховый",'М', "Жираф");
//
//        create(nycZoo);

//        System.out.println(getById(1));

//        for (NYC_Zoo n:getAll()) {
//            System.out.println("\n"+n);
//        }
//        update(1,"Лев");
//        delete(2);
        deleteAll();
    }


    public static int create(NYC_Zoo zoo){

        try(Session session =
                HibernateUtil3.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(zoo);
            session.getTransaction().commit();

            System.out.println("Успешно добавлено \n" + zoo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return zoo.getId();
    }

    public static NYC_Zoo getById(int id){
        NYC_Zoo nycZoo=null;
        try(Session session=
                HibernateUtil3.getSessionFactory().openSession()){
            session.beginTransaction();
            nycZoo=session.get(NYC_Zoo.class,id);
            session.getTransaction().commit();
            System.out.println("Got id= " +nycZoo.getId());
        }catch (Exception e){
         e.printStackTrace();
        }
        return nycZoo;
    }

    public static List<NYC_Zoo> getAll(){
        List<NYC_Zoo> nycZooList =null;
        try(Session session =
                HibernateUtil3.getSessionFactory().openSession()){
            session.beginTransaction();
            nycZooList=session.createQuery("from NYC_Zoo").getResultList();
            session.getTransaction().commit();
            System.out.println("There are: " +nycZooList.size() );
        }catch (Exception e){
            e.printStackTrace();
        }
        return nycZooList;
    }

    public static void update(int id,String family){
        try(Session session=
                HibernateUtil3.getSessionFactory().openSession()){
            session.beginTransaction();
            NYC_Zoo nycZoo=session.get(NYC_Zoo.class,id);
            nycZoo.setFamily(family);
            session.getTransaction().commit();
            System.out.println("Successfully updated "+nycZoo.getNickName() +"'s "+" family");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try(Session session=
                HibernateUtil3.getSessionFactory().openSession()){
            session.beginTransaction();
            NYC_Zoo nycZoo=session.get(NYC_Zoo.class,id);
            session.delete(nycZoo);
            session.getTransaction().commit();
            System.out.println("Удалены данные: " +nycZoo.getNickName());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void deleteAll(){
        try(Session session=
                HibernateUtil3.getSessionFactory().openSession()){
            session.beginTransaction();
            Query query=session.createQuery("delete from NYC_Zoo ");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Удалены все данные из NYC_ZOO");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
