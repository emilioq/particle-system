package PaSkCode;

import java.util.ArrayList;

public class PSysModel {
    // ArrayList or similar of particles
    // each particle: x, y, velX, velY, radius
    
    ArrayList <PSysModel> particleList;
    
    private int x;
    private int y;
    private int velX;
    private int velY;
    private int radius;

    PSysModel(int rad, int px, int py, int vx, int vy) {
        x = px;
        y = py;
        velX= vx;
        velY = vy;
        radius = rad;
    }
    

    PSysModel() {
	// instantiate list of particles
        particleList = new ArrayList <PSysModel>();
    }
    
    public int getX(){
        return x;
    }
   
    public int getY(){
        return y;
    }
    
    public int getRadius(){
        return radius;
    }
    
    void printSysInfo(){
        int pSize = particleList.size();
        for (int i = 0; i < pSize; i++){
            PSysModel current = particleList.get(i);
            System.out.print(current.radius + " " + 
                             current.x + " " + 
                             current.y + " " + 
                             current.velX + " " +
                             current.velY + " ");
            System.out.println();  
        }
    }
    

    // add a particle to list
    void add(int rad, int x, int y, int vx, int vy) {
        PSysModel temp = new PSysModel(rad, x, y, vx, vy);
        particleList.add(temp);
    }


    // update state of each particle in list
    void update(int bw, int bh) {
        
        int pSize = particleList.size();
        for (int i = 0; i < pSize; i++){
            PSysModel current = particleList.get(i);
            
            current.x += current.velX;
            current.y += current.velY;

            if (current.x >= bw-current.radius && current.velX > 0) {
                current.velX = -(current.velX);
            }
            else if (current.x < current.radius && current.velX < 0) {
                current.velX = -(current.velX);
            }

            if (current.y >= bh-current.radius && current.velY > 0) {
                current.velY = -(current.velY);
            }
            else if (current.y < current.radius && current.velY < 0) {
                current.velY = -(current.velY);
            }
            
        }
    }
}
