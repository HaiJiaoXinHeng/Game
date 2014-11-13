package SpatialEntities;

import java.io.Serializable;
import resources.Res;

/**
 * Created by chthonic7 on 10/15/14.
 */
public abstract class Territory implements Serializable {
    protected double locationX,locationY; //Or any sort of spatial positioning...
    //protected resources.Res res=new resources.Res();
    //Current method of getting resources doesn't necessitate a resources.Res object, only at continent level is it necessary
    protected String name, owner;
    protected Res res;
    protected Territory superTerr;
    protected Territory[] subTerr;

    protected Territory(double locX, double locY, Territory superTerr, Territory[] terr, Res res, String name, String owner){
        this.subTerr=terr;
        this.superTerr=superTerr;
        this.locationX=locX;
        this.locationY=locY;
        this.res=res;
        this.name=name;
        this.owner=owner;
    }
    public final double getLocationX() {
        return locationX;
    }

    public final void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public final double getLocationY() {
        return locationY;
    }

    public final void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getOwner() {
        return owner;
    }

    public final void setOwner(String owner) {
        this.owner = owner;
    }

    public final Territory getSuperTerr() {
        return superTerr;
    }

    public final void setSuperTerr(Territory superTerr) {
        this.superTerr = superTerr;
    }

    public final Territory[] getSubTerr() {
        return subTerr;
    }

    public final void setSubTerr(Territory[] subTerr) {
        this.subTerr = subTerr;
    }

    public final double getResource(String resourceName){
        return res.getResource(resourceName);
    }

    public final boolean setResource(String resourceName, double value){
        return res.setResource(resourceName,value);
    }

    public final void updateResources(){
        if (subTerr!=null) {
            for (Territory terr : this.subTerr) {
                for (String str : terr.listResources()) {
                    this.res.setResource(str, this.res.getResource(str) + terr.getResource(str));
                }
            }
        }
    }
    protected final String[] listResources(){
        return this.res.listResource();
    }
    public String toString(){
        return "("+locationX+","+locationY+") is owned by "+owner+"\n";
    }
}
