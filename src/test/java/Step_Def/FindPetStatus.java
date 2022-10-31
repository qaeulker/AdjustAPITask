package Step_Def;

import Pages.Find_pet_status;
import io.cucumber.java.en.Given;

public class FindPetStatus {

    Find_pet_status find_petStatus = new Find_pet_status();

    @Given("Find pets by {string}")
    public void find_pets_by(String status) {
        find_petStatus.get_pet_ByStatus(status);
    }
}
