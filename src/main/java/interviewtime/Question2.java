package interviewtime;

// map <amt int ,sta str)
//
//100, 'S'
//
//250, 'S'
//
//300,'F'
//
//200, 'S'
//
public class Question2 {
    public static void main(String[] args) {

    }

    // map.entrySet()
    //    .stream()
    //    .filter(i -> i.getValue().equals("Success"))
    //    .map(Map.Entry::getKey)
    //    .sum();
}

//
//
// Student cols : student_name, Id, Dept id, gender
// Dept Table cols : dept_id, dept_name, head_name, no_of_seats

// list all the dept ids where the dept is registered with >=90% students

// select d.dept_id, s.student_name, d.dept_name,  count()  from student s
//      inner join dept d
//      on s.dept_id = d.dept_id
//      GROUP BY d.dept_name
//      WHERE count(*) > (d.no_of_seats)*90/100;
