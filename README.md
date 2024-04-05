# Remindr 📅

Welcome to the Event Reminder! This Java Spring-based application provides a convenient way to manage and schedule reminders for events.

## Features ✨

1. **Authentication and Hashcode Based Reminder System**: Users can securely authenticate and create reminders for events using a hashed authentication system.
   
2. **Dynamic Reminder Time Calculation**: The application calculates the reminder time dynamically based on the arguments passed during event creation.

3. **Utilizes Java Calendar for Scheduling**: Events are scheduled and managed using Java's Calendar functionality, ensuring accurate and reliable scheduling.

4. **Future Integration with Message Queues**: In future versions, the application will integrate with message queues for asynchronous delivery of reminder emails, enhancing performance and scalability.

## Usage 🚀

1. **Authentication**: Users need to authenticate themselves securely before accessing the reminder system.

2. **Creating Reminders**: Users can create reminders for events by providing event details and specifying the desired reminder time.

3. **Scheduling Reminders**: The application schedules reminders based on the specified time and sends emails to notify users about upcoming events.

## Technologies Used 💻

- Java Spring Framework
- Java Calendar API
- (Future) Message Queues for Asynchronous Email Delivery

## Installation ⚙️

1. Clone the repository to your local machine.
   
2. Install dependencies using Maven
   
3. Run the application


## Future Enhancements 🌟

- Implementing message queues for asynchronous email delivery.
- Enhancing user interface and experience.
- Adding support for recurring events.

## Contributing 🤝

Contributions are welcome! Please feel free to fork the repository, make pull requests, and suggest improvements.

## License 📄

This project is licensed under the [MIT License](LICENSE).
