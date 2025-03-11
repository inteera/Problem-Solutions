/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1){
            return new int[]{0};
        }

        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        int i = 1, temp = 1;
        for(int element : temperatures){
            if(!stack.empty()){
                if(element <= stack.peek()){
                    i++;
                    stack.push(element);
                    continue;
                }
                while(!stack.empty() && element > stack.peek()){
                    i--;
                    answer[i] = temp;
                    temp++;
                    stack.pop();
                }
                stack.push(element);
                temp = 1;
                i += 2;
            }
            else{
                stack.push(element);
            }
            
        }

        return answer;
    }
}
// @lc code=end

