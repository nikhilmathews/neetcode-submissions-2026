class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> lastSeenAsteroids = new Stack();
        for(int i=0; i < asteroids.length; i++) {
            int currAsteroid = asteroids[i];
            if(currAsteroid > 0) {
                lastSeenAsteroids.push(currAsteroid);
            }
            else {
                while(!lastSeenAsteroids.isEmpty()) {
                    int lastAsteroid = lastSeenAsteroids.peek();
                    if(lastAsteroid > 0) {
                        if(lastAsteroid < Math.abs(currAsteroid)) {
                            lastSeenAsteroids.pop();
                        }
                        else if(lastAsteroid == Math.abs(currAsteroid)) {
                            lastSeenAsteroids.pop();
                            currAsteroid = 0;
                            break;
                        }
                        else {
                            currAsteroid = 0;
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                if(currAsteroid < 0) {
                    lastSeenAsteroids.push(currAsteroid);
                }
            }
        }
        int[] result = new int[lastSeenAsteroids.size()];
        for(int i=result.length - 1; i >= 0; i--) {
            result[i] = lastSeenAsteroids.pop();
        }
        return result;
    }
}