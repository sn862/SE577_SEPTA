# Train Demo

Train Demo is a web application that simulates planning a trip and purchasing tickets for a train or bus ride. It uses real Amtrak data retrieved via a [FOIA request](https://www.muckrock.com/foi/united-states-of-america-10/machine-readable-amtrak-schedules-fares-and-stoproute-alignments-25904/). The majority of this application is unimplemented and left as an exercise.

## Getting Started

1. Fork this repository.

2. Clone your forked repo.

3. Download the latest version of [Postgres](https://www.postgresql.org/download/) for your OS. Install with the default options and remember the admin password you set.

4. Open pgAdmin 4 (this comes with Postgres) and create a new database called "TrainDemo".

5. Unzip `amtrak_sql.zip` and run `init_tables.sql` then `init_data.sql` on your new database. This populates our database with some initial tables and data. The easiest way to run queries is with Query Tool (`Tools > Query Tool`) in pgAdmin 4.

6. Update `src/main/resources/application.properties` with your Postgres password. Make sure not to commit changes to this file to source control.

7. Add your GitHub `client-id` and `client-secret` to your `application.properites`. See the "Authentication" section.

8. Run the project in IntelliJ, Eclipse, or on the command line with
    ```
    mvnw clean package
    java -jar target/TrainDemo-0.0.1-SNAPSHOT.jar
    ```

9. Visit `localhost:8080` in a browser.


## Implementation Status

Use Cases for Traveller
---------------------------------------
Search Ticket                     Done
Display Available Itinerary       Done
Add to Cart(Excluding Discount)   Done
Checkout                          Done
Sign In (Excluding Register)      Done

We are still working on Admin Use cases. Regarding the design documents, for few use cases the design has changed. we are planning to submit the updated version of design document along with the final project submission




