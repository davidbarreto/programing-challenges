impl Solution {
    pub fn reverse(x: i32) -> i32 {

        let mut res: i64 = 0;
        let mut len: u32 = Self::len(x);
        let mut divisor = 10;
        let mut value = x.abs();
        let is_negative = x < 0;

        while value > 0 {
            let pow = 10_i64.pow(len) as i64;
            let digit = (value % 10) as i64;
            res += (digit * pow);

            // println!("pow = {pow}, digit = {digit}, res = {res}");

            value /= 10;
            len -= 1;
            divisor *= 10;
        }

        match is_negative {
            true => res = -res,
            false => ()
        }

        if res < (i32::MIN as i64) || res > (i32::MAX as i64) {
            return 0;
        }

        return res as i32;
    }

    fn len(number: i32) -> u32 {
        if (number == 0) {
            return 1;
        }

        (number.abs() as f64).log10().floor() as u32
    }
}