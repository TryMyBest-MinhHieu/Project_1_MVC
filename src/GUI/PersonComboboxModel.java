package GUI;


import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import DTO.Person;
import java.util.ArrayList;

public class PersonComboboxModel extends AbstractListModel<Person> implements ComboBoxModel<Person>  {
    
    private Person selectedPerson;
    private ArrayList<Person> people;

    public PersonComboboxModel(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public int getSize() {
        return people.size();
    }

    @Override
    public Person getElementAt(int index) {
        return people.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedPerson = (Person) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedPerson;
    }
    
}
