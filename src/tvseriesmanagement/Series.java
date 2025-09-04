
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tvseriesmanagement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class Series {
    private ArrayList<SeriesModel> seriesList;
    private Scanner scanner;
    
    public Series() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    // Main method to start the application
    public static void main(String[] args) {
        Series app = new Series();
        app.displayMainMenu();
    }
    
    // Display main menu
    public void displayMainMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n" + "=========================");
            System.out.println("LATEST SERIES - 2025");
            System.out.println("========================");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            
            String input = scanner.nextLine();
            
            if (input.equals("1")) {
                showMenuOptions();
            } else {
                running = false;
                ExitSeriesApplication();
            }
        }
    }
    
    // Display menu options
    public void showMenuOptions() {
        boolean menuRunning = true;
        
        while (menuRunning) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    CaptureSeries();
                    break;
                case "2":
                    SearchSeries();
                    break;
                case "3":
                    UpdateSeries();
                    break;
                case "4":
                    DeleteSeries();
                    break;
                case "5":
                    SeriesReport();
                    break;
                case "6":
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    // Capture new series
    public void CaptureSeries() {
        System.out.println("\n" + "*************************");
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("======================");
        
        System.out.print("Enter the series id: ");
        String seriesId = scanner.nextLine();
        
        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();
        
        String seriesAge = "";
        boolean validAge = false;
        
        // Age restriction input validation
        while (!validAge) {
            System.out.print("Enter the series age restriction: ");
            String ageInput = scanner.nextLine();
            
            // Check if input is numeric
            try { // (w3Schools, 2025)
                int age = Integer.parseInt(ageInput);
                if (age >= 2 && age <= 18) {
                    seriesAge = ageInput;
                    validAge = true;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }
        
        System.out.print("Enter the number of episodes for " + seriesName + ": ");
        String episodes = scanner.nextLine();
        
        // Add series to collection
        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, episodes);
        seriesList.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            ExitSeriesApplication();
        }
    }
    
    // Search for a series by ID
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String searchId = scanner.nextLine();
        
        SeriesModel foundSeries = findSeriesById(searchId);
        
        System.out.println("-------------------------");
        
        if (foundSeries != null) {
            System.out.println("SERIES ID: " + foundSeries.SeriesId);
            System.out.println("SERIES NAME: " + foundSeries.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + foundSeries.SeriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + foundSeries.SeriesNumberOfEpisodes);
        } else {
            System.out.println("Series with Series Id: " + searchId + " was not found!");
        }
        
        System.out.println("--------------------------------");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            ExitSeriesApplication();
        }
    }
    
    // Update series information
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine();
        
        SeriesModel seriesToUpdate = findSeriesById(updateId);
        
        if (seriesToUpdate != null) {
            System.out.print("Enter the series name: ");
            String newName = scanner.nextLine();
            
            String newAge = "";
            boolean validAge = false;
            
            // Validate age restriction input
            while (!validAge) {
                System.out.print("Enter the age restriction: ");
                String ageInput = scanner.nextLine();
                
                try { // (w3Schools, 2025). Idea from AI (
                    int age = Integer.parseInt(ageInput);
                    if (age >= 2 && age <= 18) {
                        newAge = ageInput;
                        validAge = true;
                    } else {
                        System.out.println("You have entered a incorrect series age!!!");
                        System.out.print("Please re-enter the series age >> ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            }
            
            System.out.print("Enter the number of episodes: ");
            String newEpisodes = scanner.nextLine();
            
            // Update series
            seriesToUpdate.SeriesName = newName;
            seriesToUpdate.SeriesAge = newAge;
            seriesToUpdate.SeriesNumberOfEpisodes = newEpisodes;
            
            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series with Series Id: " + updateId + " was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            ExitSeriesApplication();
        }
    }
    
    // Delete series
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String deleteId = scanner.nextLine();
        
        SeriesModel seriesToDelete = findSeriesById(deleteId);
        
        if (seriesToDelete != null) {
            System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete.\n");
            String confirmation = scanner.nextLine().toLowerCase();
            
            if (confirmation.equals("y") || confirmation.equals("yes")) {
                seriesList.remove(seriesToDelete);
                System.out.println("-------------------------");
                System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
                System.out.println("-------------------------");
            } else {
                System.out.println("Delete operation cancelled.");
            }
        } else {
            System.out.println("Series with Series Id: " + deleteId + " was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            ExitSeriesApplication();
        }
    }
    
    // Display series report
    public void SeriesReport() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025");
        System.out.println("(6) Exit Application.");
        System.out.println("5");
        
        if (seriesList.isEmpty()) {
            System.out.println("No series data available to display.");
        } else {
            for (int i = 0; i < seriesList.size(); i++) {
                SeriesModel series = seriesList.get(i);
                System.out.println("Series " + (i + 1));
                System.out.println("-------------------------");
                System.out.println("SERIES ID: " + series.SeriesId);
                System.out.println("SERIES NAME: " + series.SeriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.SeriesAge);
                System.out.println("NUMBER OF EPISODES: " + series.SeriesNumberOfEpisodes);
                System.out.println("-------------------------");
            }
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            ExitSeriesApplication();
        }
    }
    
    // Exit the application
    public void ExitSeriesApplication() {
        System.out.println("Thank you for using the TV Series Management Application!");
        scanner.close();
        System.exit(0);
    }
    
    // Helper method to find series by ID
    private SeriesModel findSeriesById(String id) {
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                return series;
            }
        }
        return null;
    }
}
/*

Reference List:

W3Schools, 2025. Java Exceptions - Try...Catch. [online] Available at: <https://www.w3schools.com/java/java_try_catch.asp> [Accessed 27 August 2025].

*/
