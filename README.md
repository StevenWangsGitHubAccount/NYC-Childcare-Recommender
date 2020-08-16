# final-project-the-new-yorkers-daycare
final-project-the-new-yorkers-daycare created by GitHub Classroom

This Java application provides the user with a list of recommended daycare centers within a New York City zip code. It begins by retrieving the inspection records of New York City daycare centers from the City's OpenData website. The user then inputs a zip code and the type of daycare program that they are looking for (e.g., pre-school, infants and toddlers, school-based, etc.). It returns a list of daycare centers of that type and located in that zip code that have the best inspection records. 

This application was developed by Steven Wang, Xiaoya Huang, and Anna Jones as the final project in Penn MCIT Online 591 (Introduction to Software Development) , Spring Semester 2019.

1. Class name: httpReader by Xiaoya H
Method: A class to access the public childcare center data through its API and download the file in JSON format, and a main method to implement it.

2. Class name: JSONGetter by Steve W
Method: This was an early attempt to learn to deal with JSON data. It won't be used in the final program.

3. Class name: Recommender by Steve W
Method: assignRatings: assigns a rating to each day care center, compareAgainstCityAverage: helper method for assignRatings, sortByInspectionRate: sorts inspection records in ArrayList from most to least recent

4. Class name: DataParser by Steve W
Method: convertToJSONArray: takes data in string format (i.e., the data retrieved from the NYC Open Data Set by httpReader class) and converts it into a JSONArray, createInspectionsArrayList: Iterates through JSONArray and extracts the data from each JSONObject to create a DayCareProviderModel object representing the outcome of each inspection

5. Class name: DayCareProviderModel by Anna J
Method: Getters and setters for variables in the dataset

6. Class name: DayCareGenie by Anna J
Method: getDayCaresByZipcode that pass in String zipcode and/or Date inspectionDate

7. Class name: Main (shared class)
Method: main method

8. Class name: RecommenderTester by Steve Wang
Method: Junit test that creates a toy ArrayList of DayCareProviderModel objects and uses that to test the assignRatings method of the Recommender class

9. Class name: userInput by Xiaoya H
Method: isValidZipcode - to validate the zipcode that user enters
is validChildAge - to validate the child age that user enters
getUserInput - to communicate with user to get the valid inputs (zipcode, child age)
