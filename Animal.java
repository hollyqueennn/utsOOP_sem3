public class Animal{
    
    public Integer id, typeofAnimal, quantity, yearofArrival;
    public String animalName;
    public String checkStatus;
    
    public Animal(int id, int typeofAnimal, int quantity, int yearofArrival, String animalName){
        this.id = id;
        this.typeofAnimal = typeofAnimal;
        this.quantity = quantity;
        this.yearofArrival = yearofArrival;
        this.animalName = animalName;
        if(year <= 2010 && year >= 2000)
			this.checkStatus = "Urgent";
		else
			this.checkStatus = "Normal";

    }
}