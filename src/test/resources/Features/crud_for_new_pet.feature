Feature: CRUD for new pet

  Scenario: CRUD for pet
    Given Add a new pet to the store-POST
    When Verify if the new pet is added
    When find a pet which is existing by ID-GET
    When Update an existing pet-PUT
    When Delete a pet-DELETE

  Scenario Outline: GET by "<status>"
    Given Find pets by "<status>"
    Examples:
      | status    |
      | available |
      | pending   |
      | sold      |



