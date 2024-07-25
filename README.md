Configuration
This project uses a config.json file for configuration, which is not included in the repository for security reasons. To set up the project:

Copy src/main/resources/config.example.json to src/main/resources/config.json
Edit config.json with your specific configuration details:

Update the BaseUrl to point to your test environment
Set the EvidenceDirectory to your desired location for test evidence
Add the necessary Users with their respective credentials



Important: Never commit your config.json file to the repository, as it may contain sensitive information.