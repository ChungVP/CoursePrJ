package edu.iuh.fit.se;

/**
 * Description: This class represents the information of a course
 * author Chung, Pham Van
 * @version 1.0
 * Created: 8/29/2024 10:10 PM
 */
public class Course {

    private int credit;
    private String department;
    private String id;
    private String title;

    /**
     * Description: The constructors with parameter
     */
    public Course(){
        this.credit = 0;
        this.department = "none";
        this.id = "none";
        this.title = "none";
    }

    /**
     * Description: Constructor with parameters
     * @param credit: the credit of the course
     * @param department: the department of the course
     * @param id: the id of the course
     * @param title: the title of the course
     */
    public Course (int credit, String department, String id, String title){

        this.credit = credit;
        this.department = department;
        this.id = id;
        this.title = title;
    }

    /**
     * Description: Set the credit of the course
     * @throws IllegalArgumentException if credit is less than 0
     */
    public void setCredit(){
        if (credit < 0){
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }
    /**
     * Description: Set the department of the course
     */
    public void setDepartment(){
        this.department = department;
    }
    /**
     * Description: Set the id of the course
     * @throws IllegalArgumentException if id isn't have at least 3 characters
     * @throws IllegalArgumentException if id isn't have only letters or digits
     */
    public void setId(){
        if (id.length() < 3 || id == null){
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        for (int i =0 ;i < id.length(); i++){
            if(!Character.isLetterOrDigit(id.charAt(i))){
                throw new IllegalArgumentException("ID must contain only letters or digits");
            }
        }
        this.id = id;
    }

    /**
     * Description: Set the title of the course
     * @throws IllegalArgumentException if title is empty
     */
    public void setTitle(){
        if (title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    /**
     * Description: Get the credit of the course
     * @return credit The credit of the course
     */
    public int getCredit(){
        return credit;
    }
    /**
     * Description: Get the department of the course
     * @return department The department of the course
     */
    public String getDepartment(){
        return department;
    }

    /**
     * Description: Get the id of the course
     * @return id The id of the course
     */
    public String getId(){
        return id;
    }
    /**
     * Description: Get the title of the course
     * @return title The title of the course
     */
    public String getTitle(){
        return title;
    }

    /**
     * Description: Get the format to println
     * @return String.format
     */
    @Override
    public String toString() {
        return String.format("%-20s%-30s%-5d%-30s",id,title,credit,department);
    }
}




















