impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        
        if prerequisites.is_empty() {
            return true;
        }

        let num_courses = num_courses as usize;
        let graph = Self::build_graph(num_courses, &prerequisites);
        let mut visiting = vec![false; num_courses];
        let mut visited = vec![false; num_courses];

        for course in 0..num_courses {
            if !visited[course] {
                if !Self::dfs(course, &graph, &mut visiting, &mut visited) {
                    return false;
                }
            }
        }

        true
    }

    fn dfs(course: usize, graph: &Vec<Vec<usize>>, visiting: &mut Vec<bool>, visited: &mut Vec<bool>) -> bool {

        visiting[course] = true;

        for neighbor in &graph[course] {
            if visiting[*neighbor] {
                return false;
            } else if !visited[*neighbor] && !Self::dfs(*neighbor, graph, visiting, visited) {
                return false;
            }
        }

        visiting[course] = false;
        visited[course] = true;
        true
    }

    fn build_graph(num_courses: usize, prerequisites: &Vec<Vec<i32>>) -> Vec<Vec<usize>> {

        let mut graph = vec![vec![]; num_courses];
        for pair in prerequisites {
            graph[pair[0] as usize].push(pair[1] as usize);
        }

        graph
    }
}