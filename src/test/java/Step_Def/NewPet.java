package Step_Def;

import Pages.CRUD_pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NewPet {

    CRUD_pet CRUD_pet = new CRUD_pet();

    @Given("Add a new pet to the store-POST")
    public void add_a_new_pet_to_he_store() {
        CRUD_pet.CreateNewPet();
    }

    @When("Verify if the new pet is added")
    public void verify_if_the_new_pet_is_added() {
        CRUD_pet.verifyCreatedPet();
    }

    @When("find a pet which is existing by ID-GET")
    public void find_a_pet_which_is_existing_by_ID() {
        CRUD_pet.get_pet_ByID();

    }

    @When("Update an existing pet-PUT")
    public void update_an_existing_pet() {
        CRUD_pet.update_pet();
    }

    @When("Delete a pet-DELETE")
    public void delete_a_pet() {
        CRUD_pet.delete_pet();
    }

}
