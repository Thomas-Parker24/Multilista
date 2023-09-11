/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MULTI;

import java.text.MessageFormat;

/**
 *
 * @author El Sapo Perro
 */
public class NightClubList {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private NightClubNode StartedNode;
    private int NightClubNodesLenght;
    private int TableNodesLenght;
    private int PersonNodesLenght;
    private final String NightClubNodeStringFormat = "\nNombre: {0}\nDirección: {1}\n-----------"; 
    private final String TablebNodeStringFormat = "\nNombre: {0}\nID: {1}\n-----------"; 
    private final String PersonNodeStringFormat = "\nNombre: {0}\nID: {1}\n-----------"; 
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    public NightClubList(){
        this.NightClubNodesLenght = 0;
        this.PersonNodesLenght = 0;
        this.TableNodesLenght = 0;
        this.StartedNode = null;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    
    //<editor-fold defaultstate="collapsed" desc="ToStringMethods">
    
    public String PersonNodesToString(String NightClubName, int TableID){
        
        if(NightClubName.isBlank() || TableID < 0)
            return null;
        
        TableNode TableHead = GetTableNodeByID(TableID, NightClubName);
        PersonNode AuxiliarNode = TableHead.GetPersonPointer();
        
        if(TableHead == null || AuxiliarNode == null)
            return null;
        
        String ListToString = "";
        
        while(AuxiliarNode != null){
            String NodeToString = MessageFormat.format(TablebNodeStringFormat, 
                    AuxiliarNode.GetName(), AuxiliarNode.GetID());
            
            if(ListToString.isEmpty()|| ListToString.isBlank())
                ListToString = NodeToString;
            else
                ListToString = ListToString + NodeToString;
            
            AuxiliarNode = AuxiliarNode.GetNextNode();
        }
        
        return ListToString;
        
    }
    
    public String TableNodesToString(String NightClubName){
        
        String ListToString = ""; 
        TableNode AuxiliarNode = GetNightClubNodeByName(NightClubName).GetTablePointer();
        
        while(AuxiliarNode != null){
            String NodeToString = MessageFormat.format(TablebNodeStringFormat, 
                    AuxiliarNode.GetName(), AuxiliarNode.GetID());
            
            if(ListToString.isEmpty()|| ListToString.isBlank())
                ListToString = NodeToString;
            else
                ListToString = ListToString + NodeToString;
            
            AuxiliarNode = AuxiliarNode.GetNextNode();
        }
        
        return ListToString;
        
    }
    
    public String NightClubNodesToString(){
        
        String ListToString = ""; 
        NightClubNode AuxiliarNode = StartedNode;
        
        while(AuxiliarNode != null){
            String NodeToString = MessageFormat.format(NightClubNodeStringFormat, 
                    AuxiliarNode.GetName(), AuxiliarNode.GetAddress());
            
            if(ListToString.isEmpty()|| ListToString.isBlank())
                ListToString = NodeToString;
            else
                ListToString = ListToString + NodeToString;
            
            AuxiliarNode = AuxiliarNode.GetNextNode();
        }
        
        return ListToString;
        
    }
    
    //</editor-fold>
    
    //<editor-fold  defaultstate="collapsed" desc="Insert">
    
    public Boolean InsertPeronNodeInHead(PersonNode NodeToAdd, String NightClubName, int TableID){
        
        if(NodeToAdd == null || NightClubName.isBlank() || TableID < 0)
            return false;
        
        TableNode TableHead = GetTableNodeByID(TableID, NightClubName);
        
        if(TableHead == null)
            return false;
        
        PersonNode AuxiliarNode = TableHead.GetPersonPointer();
        
        if(AuxiliarNode == null)
            TableHead.SetPersonPointer(NodeToAdd);
        else 
        {
            NodeToAdd.SetNextNode(AuxiliarNode);
            TableHead.SetPersonPointer(NodeToAdd);
        }
        
        System.out.println("Se insertó correctamente la persona en la mesa");
        return true;
    }
    
    public Boolean InsertNightClubNodeInHead(NightClubNode NodeToAdd){
       
       if(NodeToAdd == null)
           return false;
       
       if(StartedNode == null)
           StartedNode = NodeToAdd;
       else{
           NodeToAdd.SetNextNode(StartedNode);
           StartedNode = NodeToAdd;
           NightClubNodesLenght++;
       }
       
       System.out.println("Se insertó correctamente el nodo discoteca en la cabeza de la lista");
       return true;
    }
   
    public Boolean InsertTableNodeInHead(TableNode NodeToAdd, String NightClubName){
       
       if(NodeToAdd == null || NightClubName.isEmpty())
           return false;
       
       NightClubNode NightClubNode = GetNightClubNodeByName(NightClubName);
       
       if(NightClubNode == null)
           return false;
       
       TableNode TableNode = NightClubNode.GetTablePointer();
       
       if(TableNode == null){
          NightClubNode.SetTablePointer(NodeToAdd);
       }else{
           NodeToAdd.SetNextNode(TableNode);
           NightClubNode.SetTablePointer(NodeToAdd);
       }
       
       return true;
    }
    
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="GetNodes">
    public NightClubNode GetNightClubNodeByName(String NightClubName){
       
       if(NightClubName.isEmpty())
           return null;
       
       NightClubNode AuxiliarNode = StartedNode;
       
       while(AuxiliarNode != null){
           if(AuxiliarNode.GetName().equals(NightClubName))
               return AuxiliarNode;
           else 
               AuxiliarNode = AuxiliarNode.GetNextNode();
       }
       
       return null;
    }
    
    public TableNode GetTableNodeByID(int ID, String NightClubName){
        
        TableNode AuxiliarNode = GetNightClubNodeByName(NightClubName).GetTablePointer();
        
        while(AuxiliarNode != null){
            if(AuxiliarNode.GetID() == ID)
                return AuxiliarNode;
            
            AuxiliarNode = AuxiliarNode.GetNextNode();
        }
        
        return null;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Delete Methods">
    
    public Boolean DeletePersonInTable(int IDPersonToDelete, TableNode TableNode){
        
        if(TableNode == null)
            return false;
        
        if(TableNode.GetPersonPointer() == null)
            return false;
        
        PersonNode CurrentNode = TableNode.GetPersonPointer();
        PersonNode PreviousNode = null;
        
        if(CurrentNode == null)
            return false;
        
        while(CurrentNode.GetID() != IDPersonToDelete){
            PreviousNode = CurrentNode;
            CurrentNode = CurrentNode.GetNextNode();
        }
        
        if(CurrentNode.GetID() != IDPersonToDelete)
            return false;
        
        if(PreviousNode == null)
        {
            TableNode.SetPersonPointer(CurrentNode.GetNextNode());
            return true;
        }
        PreviousNode.SetNextNode(CurrentNode.GetNextNode());
        System.out.println("Se eliminó correctamente a la persona");
        return true;
    }
    
    public Boolean DeleteTableInNightClub(TableNode TableToDelete, NightClubNode NightClubNode){
        
        if(TableToDelete == null || NightClubNode == null)
            return false;
        
        if(NightClubNode.GetTablePointer() == null)
            return false;
        
        if(TableToDelete == NightClubNode.GetTablePointer())
        {
            NightClubNode.SetTablePointer(TableToDelete.GetNextNode());
            return true;
        }
        
        TableNode PreviousTableNode = NightClubNode.GetTablePointer();
        
        while(PreviousTableNode.GetNextNode() != TableToDelete  && PreviousTableNode != null){
            PreviousTableNode = PreviousTableNode.GetNextNode();
        }
        
        if(PreviousTableNode == null)
            return false;
        
        PreviousTableNode.SetNextNode(TableToDelete.GetNextNode());
        System.out.println("Se eliminó correctamente a la mesa");
        return true;
    }
    
    public Boolean DeleteTableInNightClub(TableNode TableToDelete, NightClubNode NightClubNode, int TableIDToPastePersonHeader){
        
        if(TableToDelete == null || NightClubNode == null || NightClubNode.GetTablePointer() == null)
            return false;
        
        if(TableToDelete == NightClubNode.GetTablePointer() && TableToDelete.GetPersonPointer() != null){
            System.out.println("No se puede eliminar el nodo mesa porque es la cabeza y tiene personas asociadas a ella.");
            return false;
        }
        
        TableNode TableNodeToPastePeople = NightClubNode.GetTablePointer();
        
        while(TableNodeToPastePeople.GetID() != TableIDToPastePersonHeader && TableNodeToPastePeople != null){
            TableNodeToPastePeople = TableNodeToPastePeople.GetNextNode();
        }
        
        if(TableNodeToPastePeople == null)
            return false;
        
        if(TableNodeToPastePeople.GetPersonPointer() == null)
            TableNodeToPastePeople.SetPersonPointer(TableToDelete.GetPersonPointer());
        else{
            
            PersonNode AuxiliarNode = TableToDelete.GetPersonPointer();
            while(AuxiliarNode.GetNextNode() != null){
                AuxiliarNode = AuxiliarNode.GetNextNode();
            }
            
            AuxiliarNode.SetNextNode(TableNodeToPastePeople.GetPersonPointer());
            TableNodeToPastePeople.SetPersonPointer(TableToDelete.GetPersonPointer());
        }
        
        if(TableToDelete == NightClubNode.GetTablePointer())
            NightClubNode.SetTablePointer(TableToDelete.GetNextNode());
        else{
            TableNode PreviousTable = NightClubNode.GetTablePointer();
            
            while(PreviousTable.GetNextNode() != TableToDelete){
                PreviousTable = PreviousTable.GetNextNode();
            }
            
            PreviousTable.SetNextNode(TableToDelete.GetNextNode());
        }
        
        System.out.println("Mesa eliminada con éxito.");
        return true;
    }
    
    public Boolean DeleteNightClub(NightClubNode NightClubNodeToDelete, String NightClubNameToPasteTablePointer){
        
        if(NightClubNodeToDelete == null || NightClubNameToPasteTablePointer.isBlank())
            return false;
        
        NightClubNode NightClubNodeToPasteTablePointer = GetNightClubNodeByName(NightClubNameToPasteTablePointer);
        
        if(NightClubNodeToPasteTablePointer == null)
            return false;
        
        if(NightClubNodeToPasteTablePointer.GetTablePointer() == null)
            NightClubNodeToPasteTablePointer.SetTablePointer(NightClubNodeToDelete.GetTablePointer());
        else{
            
            TableNode AuxiliarNode = NightClubNodeToDelete.GetTablePointer();
            
            while(AuxiliarNode.GetNextNode() != null){
                AuxiliarNode = AuxiliarNode.GetNextNode();
            }
            
            AuxiliarNode.SetNextNode(NightClubNodeToPasteTablePointer.GetTablePointer());
            NightClubNodeToPasteTablePointer.SetTablePointer(NightClubNodeToDelete.GetTablePointer());
        }
        
        return DeleteNightClub(NightClubNodeToPasteTablePointer);
    }
    
    public Boolean DeleteNightClub(NightClubNode NightClubToDelete){
        
        if(NightClubToDelete == null)
            return false;
        
        if(StartedNode.GetNextNode() == null && NightClubToDelete.GetTablePointer() != null){
            System.out.println("No se puede eliminar la discoteca ya que tiene mesas que depende de ella y no \n"
                    + "        existe una discoteca a quien transferirle los datos");
            return false;
        }
        
        if(NightClubToDelete == StartedNode){
            StartedNode = StartedNode.GetNextNode();
            return true;
        }else{
            NightClubNode PreviousNightClub = StartedNode;
            
            while(PreviousNightClub.GetNextNode() != NightClubToDelete){
                PreviousNightClub = PreviousNightClub.GetNextNode();
            }
            
            PreviousNightClub.SetNextNode(NightClubToDelete.GetNextNode());
        }
        System.out.println("Se eliminó correctamente la discoteca");
        return true;
    }
    
    //</editor-fold>
    
    //</editor-fold>

}
