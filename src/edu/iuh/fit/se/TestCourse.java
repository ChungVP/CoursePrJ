package edu.iuh.fit.se;

import java.util.Scanner;

/**
 *  This class represents a list of courses
 * @author Chung, Pham Van
 * @version 1.0
 * created 8/29/2024 10:22 PM
 */
public class TestCourse {
    /**
     * description main class to run the functions
     * @param args the arg array
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(15);

        initData(courseList);

        int choice;
        do{
            System.out.println("\n1. Add course");
            System.out.println("2. Show all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find max credit in all courses");
            System.out.println("5. Search a course by title");
            System.out.println("6. Search a course by department");
            System.out.println("7. Search a course by id");
            System.out.println("8. Sort course");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                {

                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();

                    Course course = new Course(credit,department,id,title);
                    if(courseList.addCourse(course)){
                        System.out.println("Course added completed!");
                    }
                    else {
                        System.out.println("Failed to add course!");
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Course List: ");
                    System.out.println("---------------------------------------------------------------");
                    for (Course course : courseList.getCourses()) {
                        if(course != null) {
                            System.out.println(course);
                        }
                    }
                    System.out.println("---------------------------------------------------------------");
                    break;
                }
                case 3:
                {
                    System.out.print("Enter course id to remove: ");
                    String id = sc.nextLine();
                    if(courseList.removeCourse(id)) {
                        System.out.println("Course removed completed!");
                    }
                    else {
                        System.out.println("Remove Failed!");
                    }
                    break;
                }
                case 4:
                {

                    System.out.print("List course has max credit: ");
                    System.out.println("--------------------------------------------------------------");
                    for (Course course : courseList.findMaxCreditCourse()){
                        if(course != null) {
                            System.out.println(course);
                        }
                    }
                    System.out.println("--------------------------------------------------------------");
                    break;
                }
                case 5:
                {
                    System.out.print("Enter course Title: ");
                    String title = sc.nextLine();
                    System.out.println("List course has the same Title: ");
                    System.out.println("--------------------------------------------------------------");
                    for (Course course : courseList.searchCourse(title)) {
                        if (course == null) {
                            break;
                        }
                        System.out.println(course);
                    }
                    if (courseList.searchCourse(title) == null) {
                        System.out.println("Course not found!");
                    }
                    System.out.println("--------------------------------------------------------------");
                    break;
                }
                case 6:
                {
                    System.out.print("Enter course Department: ");
                    String dePartMent = sc.nextLine();
                    System.out.println("List course has the same Department: ");
                    System.out.println("--------------------------------------------------------------");
                    for (Course course : courseList.searchCourseByDepartment(dePartMent)) {
                            if (course == null) {
                                break;
                            }
                            System.out.println(course);
                    }
                    if (courseList.searchCourseByDepartment(dePartMent) == null) {
                        System.out.println("Course not found!");
                    }
                    System.out.println("--------------------------------------------------------------");
                    break;
                }
                case 7:
                {
                    System.out.print("Enter course Id: ");
                    String id = sc.nextLine();
                    if (courseList.searchCourseById(id) != null){
                        System.out.println("Course found!");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println(courseList.searchCourseById(id));
                        System.out.println("--------------------------------------------------------------");
                    }
                    else {
                        System.out.println("Course not found!");
                    }
                    break;
                }
                case 8:
                {
                    System.out.print("List course after sorting: ");
                    courseList.sortCourse();
                    System.out.println("--------------------------------------------------------------");
                    for (Course course : courseList.getCourses()) {
                        if(course != null) {
                            System.out.println(course);
                        }
                    }
                    System.out.println("Sort successful!");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }
                default: break;
            }
        }while(choice != 0);
    }

    /**
     * Description: Create data in course list
     * @param courseList the element of CourseList
     */
    private static void initData(CourseList courseList) {
        Course course1 = new Course(4,"FIT","SE01","C+ Programming");
        Course course2 = new Course(3,"FIT","SE02","Java Programming");
        Course course3 = new Course(2,"FIT","SE03","Mobile Programming");
        Course course4 = new Course(4,"FIT","SE04","Data Science");
        Course course5 = new Course(1,"FIT","SE05","Artificial Intelligence");
        Course course6 = new Course(5,"FIT","SE06","SQL Server");
        Course course7 = new Course(3,"FIT","SE07","Machine Learning");
        Course course8 = new Course(5,"FIT","SE08","Database Programming");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }
}

