package Worker;

public class Worker {
    private static int lastID = 0;
    private String name;
    private int ID;
    private String email;
    private String phoneNumber;
    private Double salary;
    private String jobTitle;

    public Worker() {
        ID = lastID;
        lastID += 1;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public static Integer getLastID() {
        return lastID;
    }

    public static void setLastID(Integer lastID) {
        Worker.lastID = lastID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Worker{" + "name='" + name + '\'' + ", ID=" + ID + ", email='" + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", salary=" + salary + ", jobTitle='" + jobTitle + '\'' + '}';
    }
}
