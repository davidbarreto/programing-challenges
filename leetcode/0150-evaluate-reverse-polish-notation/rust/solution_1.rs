impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        
        let mut stack: Vec<i32> = Vec::new();
        for val in tokens {

            //println!("{}", val);
            if Self::is_numeric(&val) {
                //println!("numeric");
                stack.push(Self::to_integer(&val));
            } else {
                //println!("operand");
                let op1: i32 = stack.pop().unwrap();
                let op2: i32 = stack.pop().unwrap();
                let result: i32 = Self::calculate(op2, op1, &val);
                //println!("{} {} {} = {}", op1, val, op2, result);
                stack.push(result);
            }
        }

        return stack[0];
    }

    fn to_integer(number: &String) -> i32 {
        return number.parse::<i32>().unwrap();;
    }

    fn is_numeric(val: &String) -> bool {
        return val.parse::<i32>().is_ok();
    }

    fn calculate(op1: i32, op2: i32, operator: &String) -> i32 {
        let opStr = operator.as_str();
        match opStr {
            "+" => op1 + op2,
            "-" => op1 - op2,
            "*" => op1 * op2,
            "/" => op1 / op2,
            _ => 0
        }
    }
}