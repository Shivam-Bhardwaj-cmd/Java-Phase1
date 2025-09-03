import java.util.ArrayList;
public class App{
public static void main(String[] args){
ArrayList<User> users=new ArrayList<>();
users.add(new User("Shivam", 25));
users.add(new User("Rohit",28));
for(User u :users){
System.out.println("User:"+u.getName()+", Age: " + u.getAge());

}
users.get(0).setAge(26);
System.out.println("Updated Age for " + users.get(0).getName()+ ": " + users.get(0).getAge());

}
}
