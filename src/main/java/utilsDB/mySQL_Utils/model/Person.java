//package utilsDB.mySQL_Utils.model;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Objects;
//
//import static utilsDB.mySQL_Utils.connection.ConnectionManagerMySQL.dbConnection;
//
//public class Person {
//    private String name;
//    private int age;
//
//    // Default constructor
//    public Person() {
//        // You can choose to initialize the fields with default values here
//        // The error message java.lang.NoSuchMethodException: dto.Person.<init>()
//        // typically occurs when you are trying to create a new instance of the
//        // Person class using reflection, and the default constructor (no-argument constructor)
//        // is not available or accessible.
//    }
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public static Person selectPersonByName(String name) {
//        Person person = null;
//
//        try {
//            String sql = "SELECT * FROM person WHERE name = ?";
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//            statement.setString(1, name);
//
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String personName = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                person = new Person(personName, age);
//            }
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return person;
//    }
//
//    public static void updateAge(String name, int newAge) {
//        try {
//            String sql = "UPDATE person SET age = ? WHERE name = ?";
//            PreparedStatement statement = dbConnection.prepareStatement(sql);
//            statement.setInt(1, newAge);
//            statement.setString(2, name);
//
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected == 1) {
//                System.out.println("Age updated successfully for " + name);
//            } else {
//                System.out.println("Failed to update age for " + name);
//            }
//
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    // this is required to compare the Object from DB to some expected Object
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age &&
//                Objects.equals(name, person.name);
//    }
//
//}