<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Create a Java Spring Boot API to connect to the capstone 1
* Capstone 1 is an e-commerce website. There is an order, cart, customer, shipping and billing address.  
* Evaluate json file to understand if there is a logical division in more than one entity
* Explore options what to use to draw diagrams
* Build back end first and check everything in Postman
* Use Postman API docs after all CRUD commands are checked
* Decide what needed to be refactored in React
* Decide if there is a need for more components to implement CRUD on front end.
<h2>
    2. Planning the Solution
</h2>
*Create DB diagram.
*Build Spring Boot project and implement diagram creating entities, cardinality.
*Parse json file to MySQL commands to populate product table.
*Check cardinality in MySQL
*Create repository, service and controller for each entity
*Check all routes with POSTMAN and MySQL
*To implement CRUD on front end create new components for Admin view, Create Product view and Update Product view
*Create a table in Admin view with Delete, View and Update options as well as Add New Product Option
<h2>
    3. Executing the Plan
</h2>
*Created DB diagram in MySQL workbench with 6 tables: product, category, order_item, order, customer, customer_address 
*Created Entities based on the diagram with 4 OneToMany relationships and 1 OneToOne relationship.
*Parsed json file and populated Product and Category tables. Checked cardinality in MySQL.
*Create repos, services and controllers for each of the entity
*Tested all routes, Post, Get, Update and Delete for all controllers in Postman
*Made API documentation
*Created Admin with a table and buttons to show CRUD functionality. 
*Created NewProduct, UpdateProduct components with forms.
<h2>
    4. Reflection / Refactor
</h2>
*I would like to add login functionality for user and admin.
*Implement cart and order with back end.
*Refactor React App, restructure
*
*
*
*
POSTMAN API Documentation: https://documenter.getpostman.com/view/15403818/TzJx6vMe