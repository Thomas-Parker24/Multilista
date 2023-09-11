package com.mycompany.MULTI;

import javax.swing.JOptionPane;

/**
 *
 * @author El Sapo Perro
 */
public class MultiList {

    public static void main(String[] args) {
        
        int Result;
        NightClubList NightClubList = new NightClubList();
        String NightClubName;
        int TableID;
        int PersonID;
        String PersonName = "";
        
        while(true){
            
            Result = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opción:\n"
                                                                    +"1. Insertar discoteca\n"
                                                                    +"2. Recorrer lista de discotecas\n"
                                                                    +"3. Insertar mesa en discoteca\n"
                                                                    +"4. Recorrer lista de mesas en discoteca\n"
                                                                    +"5. Insertar persona en mesa\n"
                                                                    +"6. Recorrer personas en mesa\n"
                                                                    +"7. Eliminar Persona en mesa\n"
                                                                    +"8. Eliminar Mesa en Discoteca\n"
                                                                    +"9. Eliminar discoteca\n"
                                                                    +"10. Salir"));
            
            switch(Result){
                
                case 1:
                    
                    String Name = JOptionPane.showInputDialog("Digite el nombre de la discoteca:");
                    String Address = JOptionPane.showInputDialog("Digite la dirección:");
                    
                    if(Name.isEmpty() || Address.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Digitó una opción vacía");
                        break;
                    }
                    
                    NightClubNode NewNode = new NightClubNode(Name, Address);
                    NightClubList.InsertNightClubNodeInHead(NewNode);
                    break;
                    
                case 2:
                    String Message = NightClubList.NightClubNodesToString();
                    JOptionPane.showMessageDialog(null,Message );
                    break;
                    
                case 3:
                    NightClubName = JOptionPane.showInputDialog("Ingrese el nombre de la discoteca:");
                    
                    if(NightClubName.isBlank() || NightClubName.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Ingresó un nombre no válido");
                        break;
                    }
                    
                    String TableName = JOptionPane.showInputDialog("Ingrese el nombre de la mesa:");
                    TableID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mesa: "));
                    
                    TableNode NodeToAdd = new TableNode(TableName, TableID);
                    
                    NightClubList.InsertTableNodeInHead(NodeToAdd, NightClubName);
                    break;
                
                case 4:
                    JOptionPane.showMessageDialog(null, NightClubList.TableNodesToString(JOptionPane.showInputDialog("Ingrese el nombre de la discoteca")));
                    break;
                    
                case 5:
                    NightClubName = JOptionPane.showInputDialog("Ingrese el nombre de la discoteca");
                    TableID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mesa"));
                    
                    PersonName = JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
                    PersonID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la persona:"));
                    
                    PersonNode PersonNodeToAdd = new PersonNode(PersonName, PersonID);
                    
                    NightClubList.InsertPeronNodeInHead(PersonNodeToAdd, NightClubName, TableID);
                    break;
                    
                case 6:
                    NightClubName = JOptionPane.showInputDialog("Ingrese el nombre de la discoteca");
                    TableID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mesa"));
                    
                    JOptionPane.showMessageDialog(null, NightClubList.PersonNodesToString(NightClubName, TableID));
                    break;
                    
                case 7:
                    
                    NightClubName = JOptionPane.showInputDialog("Ingrese el nombre de la discoteca");
                    TableID = Integer.parseInt(JOptionPane.showInputDialog( null, "Ingrese ID de la mesa donde va a elimnar la persona"));
                    TableNode CurrentTableNode = NightClubList.GetTableNodeByID(TableID, NightClubName);
                    
                    if(CurrentTableNode == null)
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró la mesa");
                        break;
                    }
                    
                    PersonID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la persona a eliminar"));
                    
                    if(NightClubList.DeletePersonInTable(PersonID, CurrentTableNode))
                        JOptionPane.showMessageDialog(null, "Se eliminó correctamente a la persona");
                    else
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar a la persona");
                    
                    break;
                    
                case 8: 
                    
                    NightClubName = JOptionPane.showInputDialog("Ingrese el nombre de la discoteca");
                    TableID = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mesa a eliminar"));
                    
                    TableNode TableToDelete = NightClubList.GetTableNodeByID(TableID, NightClubName);
                    
                    if(TableToDelete == null)
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró la mesa a eliminar");
                        break;
                    }
                    
                    if(TableToDelete.GetPersonPointer()== null)
                        NightClubList.DeleteTableInNightClub(TableToDelete, NightClubList.GetNightClubNodeByName(NightClubName));
                    else
                        {
                            int TableToPastePeople = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la tabla a copiar los elementos de la mesa a eliminar"));
                            NightClubList.DeleteTableInNightClub(TableToDelete, NightClubList.GetNightClubNodeByName(NightClubName), TableToPastePeople);
                        }
                    
                    break;
                case 9:
                    NightClubName = JOptionPane.showInputDialog("Ingrese el nombre de la discoteca:");
                    NightClubNode AuxiliarNode = NightClubList.GetNightClubNodeByName(NightClubName);
                    
                    if(AuxiliarNode == null){
                        JOptionPane.showMessageDialog(null, "No se encontró la disoteca");
                        break;
                    }
                    
                    if(AuxiliarNode.GetTablePointer() == null)
                        NightClubList.DeleteNightClub(AuxiliarNode);
                    else 
                        NightClubList.DeleteNightClub(AuxiliarNode, JOptionPane.showInputDialog("Ingrese el nombre de la discoteca a la cual se la agregaran los datos adyancetes de la discoteca ",AuxiliarNode.GetName()));
                    
                    break;
                    
                case 10:
                    System.exit(0);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
            
        }
    }
}
