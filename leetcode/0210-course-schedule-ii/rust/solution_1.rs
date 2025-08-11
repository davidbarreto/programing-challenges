use std::collections::VecDeque;

impl Solution {
    pub fn find_order(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> Vec<i32> {

        let num_courses = num_courses as usize;
        let graph = Self::build_graph(num_courses, &prerequisites);

        let mut visiting = vec![false; num_courses];
        let mut visited = vec![false; num_courses];
        let mut courses = VecDeque::with_capacity(num_courses);

        for course in 0..num_courses {
            if !visited[course] {
                if !Self::dfs(course, &graph, &mut visiting, &mut visited, &mut courses) {
                    return Vec::new();
                }
            }
        }

        Vec::from(courses)
    }

    fn dfs(course: usize, graph: &Vec<Vec<usize>>, visiting: &mut Vec<bool>, visited: &mut Vec<bool>, courses: &mut VecDeque<i32>) -> bool {

        visiting[course] = true;

        for &neighbor in &graph[course] {
            if visiting[neighbor] {
                return false;
            }
            if !visited[neighbor] && !Self::dfs(neighbor, graph, visiting, visited, courses) {
                return false;
            }
        }

        courses.push_front(course as i32);
        visiting[course] = false;
        visited[course] = true;
        true
    }

    fn build_graph(num_course: usize, prerequisites: &Vec<Vec<i32>>) -> Vec<Vec<usize>> {

        let mut graph = vec![vec![]; num_course];

        for pair in prerequisites {
            graph[pair[1] as usize].push(pair[0] as usize);
        }

        graph
    }
}