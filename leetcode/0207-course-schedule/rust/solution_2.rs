impl Solution {
    pub fn can_finish(num_courses: i32, prerequisites: Vec<Vec<i32>>) -> bool {
        
        if prerequisites.is_empty() {
            return true;
        }

        let num_courses = num_courses as usize;
        let graph = Solution::build_graph(num_courses, &prerequisites);
        let mut visiting = vec![false; num_courses];
        let mut visited = vec![false; num_courses];

        for course in 0..(num_courses-1) {
            if !visited[course] {
                if !Solution::dfs(course, &graph, &mut visiting, &mut visited) {
                    return false;
                }
            }
        }

        true
    }

    fn dfs(course: usize, graph: &Vec<Option<Vec<i32>>>, visiting: &mut Vec<bool>, visited: &mut Vec<bool>) -> bool {

        visiting[course] = true;

        if let Some(neighbors) = graph[course].as_ref() {

            for neighbor in neighbors {
                if visiting[*neighbor as usize] {
                    return false;
                } else if !visited[*neighbor as usize] && !Solution::dfs(*neighbor as usize, graph, visiting, visited) {
                    return false;
                }
            }
        }

        visiting[course] = false;
        visited[course] = true;
        true
    }

    fn build_graph(num_courses: usize, prerequisites: &Vec<Vec<i32>>) -> Vec<Option<Vec<i32>>> {

        let mut graph = vec!(None; num_courses);
        for pair in prerequisites {

            if graph[pair[0] as usize].is_none() {
                graph[pair[0] as usize] = Some(Vec::new());
            }

            let neighbors = graph[pair[0] as usize].as_mut().unwrap();
            neighbors.push(pair[1]);
        }

        graph
    }
}
