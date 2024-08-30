package edu.iuh.fit.se;

/**
 * description This class represents a list of courses
 * author Chung, Pham Van
 * version 1.0
 * created 8/29/2024 10:22 PM
 */
public class CourseList {

    private static int count = 0;
    private Course[] courses;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length size
     * @param size The length of the array
     * @throws IllegalArgumentException if size is less than or equal to 0
     */
    public CourseList(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[size];
    }

    /**
     * Description: Get the array of the course
     * @return the course array
     */
    public Course[] getCourses(){
        return courses;
    }

    /**
     * Description: Add a course to the list
     * @param course the course to add
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     */
    public boolean addCourse(Course course){
        if (courses == null || courses.length == 0){
            return false;
        }
        if (exists(course)){
            return false;
        }
        if (count == courses.length){
            return false;
        }
        courses[count++] = course;
        return true;
    }

    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @param course The course to check
     * @return true if the course exists, false otherwise
     */
    private boolean exists(Course course){
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    /**
     * Description: Find the course which has max credit. First, find a max credit in array course. Then, Create a loop to check elements in array
     * @return the array of max credit course
     */
    public Course[] findMaxCreditCourse(){
        Course[] maxCreditCourses = new Course[count];
        int maxCredit = 0, j = 0;
        for(int i = 0; i < count; i++){
            if (courses[i].getCredit() > maxCredit){
                     maxCredit = courses[i].getCredit();
            }
        }
        for (int i = 0; i < count; i++){
            if (courses[i].getCredit() == maxCredit){
                   maxCreditCourses[j] = courses[i];
                   j++;
            }
        }
        return maxCreditCourses;
    }

    /**
     * Description: Remove a course out of the array
     * @param course_id The id of course is removed
     * @return true if the course remove is successfully, false otherwise
     * @throws IllegalArgumentException if the course_id is null, the course_id have less than 3 character, or the course_id isn't fit
     */
    public boolean removeCourse(String course_id){
        if (course_id == null){
            return false;
        }
        if (course_id.length() < 3){
            return false;
        }
        for (int i =0 ;i < course_id.length(); i++){
            if(!Character.isLetterOrDigit(course_id.charAt(i))){
                return false;
            }
        }
        for (int i = 0; i < count; i++){
            if(course_id.equals(courses[i].getId())){
                for(int j = i; j < count; j++){
                    courses[j] = courses[j+1];
                }
                break;
            }
        }
        return true;
    }

    /**
     * Description: Search a course of the list by title
     * @param course_title the title of the course
     * @return array course has same title
     */
    public Course[] searchCourse(String course_title){
        Course[] sameTitleCourses = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++){
            if (courses[i].getTitle().equals(course_title)){
                sameTitleCourses[j] = courses[i];
            }
        }
        return sameTitleCourses;
    }

    /**
     * Description: Search a course of the list by department
     * @param course_department the department of the course
     * @return array course has same department
     */
    public Course[] searchCourseByDepartment(String course_department){
          Course[] sameDepartmentCourse = new Course[count];
          int j = 0;
          for (int i = 0; i < count; i++){
              if (courses[i].getDepartment().equals(course_department)){
                  sameDepartmentCourse[i] = courses[i];
              }
          }
          return sameDepartmentCourse;
    }

    /**
     * Description: Search a course of the list by id
     * @param course_id the id of the course
     * @return a course
     */
    public Course searchCourseById(String course_id){
         for (int i = 0; i < count; i++){
             if (courses[i].getId().equals(course_id)){
                 return courses[i];
             }
         }
         return null;
    }

    /**
     * Description: Sort the array by title
     * @return a increase array
     */
    public Course[] sortCourse(){
        for (int i = 0; i < count - 1; i++){
            for (int j = i + 1; j < count; j++){
                if ( courses[i].getTitle().compareTo(courses[j].getTitle()) > 0 ){
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses;
    }

    /**
     * Description: Count the element has same department
     * @param course_department the department of course
     * @return the number of course in one department
     */
    public int countCourseInDepartment(String course_department){
        int countCourse = 0;
        for (int i = 0; i < count; i++){
            if(courses[i].getDepartment().equals(course_department)){
                countCourse++;
            }
        }
        return countCourse;
    }

    /**
     * Description: Find the Department has the most of the course
     * @return name of department
     */
    public String findDepartmentWithMostCourses(){
        int maxCourseInDepartment = 0;
        String returnNameOfDepartment = " ";
        for (Course course : getCourses()){
            if (countCourseInDepartment(course.getDepartment()) > maxCourseInDepartment){
                maxCourseInDepartment = countCourseInDepartment(course.getDepartment());
                returnNameOfDepartment = course.getDepartment();
            }
        }
        return returnNameOfDepartment;
    }
}










