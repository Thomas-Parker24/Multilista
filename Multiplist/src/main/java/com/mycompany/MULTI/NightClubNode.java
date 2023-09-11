package com.mycompany.MULTI;

/**
 *
 * @author El Sapo Perro
 */
public class NightClubNode {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    
    private String Name;
    private String Address;
    private NightClubNode NextNode;
    private TableNode TablePointer;
    
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public String GetName(){
        return this.Name;
    }
    
    public String GetAddress(){
        return this.Address;
    }
    
    public NightClubNode GetNextNode(){
        return this.NextNode;
    }
    
    public TableNode GetTablePointer(){
        return this.TablePointer;
    }
    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    
    public void SetName(String Name){
        this.Name = Name;
    }
    
    public void SetAddress(String Address){
        this.Address = Address;
    }
    
    public void SetNextNode(NightClubNode NextNode){
        this.NextNode = NextNode;
    }
    
    public void SetTablePointer(TableNode NodeToAdd){
        this.TablePointer = NodeToAdd;
    }
    
    //</editor-fold>
    
    //<editor-fold  defaultstate="collapsed" desc="Constructor">
    public NightClubNode(String Name, String Address){
        try
        {
            this.Name = Name;
            this.Address = Address;
        }catch(Exception e){
            System.out.println("Ocurrió un error al crear el objeto" + NightClubNode.class.getName());
        }
    }
    
    //</editor-fold>
    
}
