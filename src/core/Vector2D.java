package core;

public class Vector2D {
    public float x;
    public float y;
    public float earthX = 400;
    public float earthY = 400;

    public Vector2D(){
     this.x = 0.0f;
     this.x = 0.0f;
    }
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }
    public Vector2D set(Vector2D vector2D){
        return this.set(vector2D.x,vector2D.y);
    }
    public Vector2D addUp(float x, float y){
        this.x +=x;
        this.y +=y;
        return this;
    }
    public Vector2D addUp(Vector2D vector2D){
        return this.addUp(vector2D.x,vector2D.y);
    }
    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y +y);
    }
    public Vector2D add(Vector2D vector2D){
        return this.add(vector2D.x,vector2D.y);
    }
    public Vector2D subtractBy(float x, float y){
        this.x -=x;
        this.y -=y;
        return this;
    }
    public Vector2D subtractBy(Vector2D vector2D){
        return this.subtractBy(vector2D.x,vector2D.y);
    }
    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x -x,this.y -y );
    }
    public Vector2D subtract(Vector2D vector2D){
        return this.subtract(vector2D.x,vector2D.y);
    }
    public float length(){
        return (float)Math.sqrt(this.x*this.x + this.y*this.y);
    }
    public float length(Vector2D vector2D){
        return (float)Math.sqrt(vector2D.x*vector2D.x + vector2D.y*vector2D.y);
    }
    public Vector2D clone(){
        return new Vector2D(this.x,this.y);
    }
    public Vector2D multiply(float number){
        this.x *= number;
        this.y *= number;
        return this;
    }
    public Vector2D normalize(){
        if(length()!=0) {
            return new Vector2D(this.x/this.length(),this.y/this.length());
        }
        return new Vector2D();
    }
    public Vector2D rotate(double degree, Vector2D axis){
        double angle =Math.toRadians(degree);
        this.subtractBy(axis);
        float x=(float) (this.x*Math.cos(angle)-this.y*Math.sin(angle));
        float y=(float) (this.x*Math.sin(angle)+this.y*Math.cos(angle));
        return new Vector2D(x+axis.x,y+axis.y);
    }
    public Vector2D rotate(double degree){
        double angle =Math.toRadians(degree);
        float x=(float) (this.x*Math.cos(angle)-this.y*Math.sin(angle));
        float y=(float) (this.x*Math.sin(angle)+this.y*Math.cos(angle));
        return new Vector2D(x,y);
    }
    public double angleWithAVector(Vector2D vector2D){
        double angle = Math.toDegrees(Math.atan2(this.x-vector2D.x,this.y-vector2D.y));
        angle = angle+Math.ceil(-angle/360)*360;
        return angle;
    }
    public double khoangcach (float positionX, float positionY){
        double khoangcach;
        double u,v;
        u = positionX - earthX;
        v = positionY - earthY;
        khoangcach = Math.sqrt( u * u + v * v );
        return khoangcach;
    }
//    public Vector2D vectorhuongtam (float positionX,float positionY){
//        return new Vector2D(positionX-earthX,positionY-earthY);
//    }
////    public Vector2D congvectorhuongtam (Vector2D vector2D){
////        return Vector2D(x,y);
////    }

    public Vector2D gravity (float positionX, float positionY, float x, float y){
        this.x = (float) (x - (5*(positionX-earthX))/
                ((positionX-earthX)*(positionX-earthX)+(positionY-earthY)*(positionY-earthY)));
        this.y = (float) (y - (5*(positionY-earthY))/
                ((positionX-earthX)*(positionX-earthX)+(positionY-earthY)*(positionY-earthY)));
        return new Vector2D(this.x,this.y);
    }
    public Vector2D gravity2 (float positionX, float positionY, float x, float y){
        this.x = (float) (x - (30*(positionX-earthX))/
                ((positionX-earthX)*(positionX-earthX)+(positionY-earthY)*(positionY-earthY)));
        this.y = (float) (y - (30*(positionY-earthY))/
                ((positionX-earthX)*(positionX-earthX)+(positionY-earthY)*(positionY-earthY)));
        return new Vector2D(this.x,this.y);
    }
//    public Vector2D gravity(Vector2D vector2D){
//        return this.gravity(vector2D.x,vector2D.y);
//    }

    public Vector2D push (float positionX,float positionY){
        this.x = (float) (this.x - (positionX-earthX)/(khoangcach(positionX,positionY))*(khoangcach(positionX,positionY)));
        this.y = (float) (this.y - (positionY-earthY)/(khoangcach(positionX,positionY))*(khoangcach(positionX,positionY)));
        return new Vector2D(this.x,this.y);
    }

//    public Vector2D broken(Vector2D vector2D){
//        float x1;
//        int y1 = 0;
//        int u,v;
//
//        u = (int)vector2D.x;
//        v = (int)vector2D.y;
//        Random randomX = new Random(7);
//        Random randomY = new Random(7);
////        x1 = vector2D.x + randomX - 3  ;
//
//
//        return new Vector2D(x1,y1);
//    }


}
