# Reward-Mechanism-API

## ENDPOINT
- Create a project for an artist
- Buy/Sell tokens
- Show transactions relating to a token
- Show a user the details of their investment in a token

## Requirements
1. Java 17 or higher (Spring boot)
2. In-memory database (H2) 

## Installation
1. Clone the repository:
- **https://github.com/justiyz/Reward-Mechanism-API.git**
2. Open in your preferred Editor:
- i.e Eclipse, IntelliJ etc.
3. Navigate to the project directory:
- cd C:\Users****\poprev on your local computer
4. Build and run the application
- mvn clean build
- mvn clean install

## Database Setup
- No set-up required, just run the application

## API Endpoints
- `POST artists/`: Create a project for an artist
- `POST tokens/`: Buy/Sell tokens
- `GET tokens/transactions/{tokenId}`: Show transactions relating to a token
- `GET tokens/investment/{userId}/{investmentId}`: Show a user the details of their investment in a token
