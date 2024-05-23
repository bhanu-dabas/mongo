def call() {
    // Clone the repository
    git branch: 'main', url: 'https://github.com/bhanu-dabas/mongo.git'
    
    // Automatically approve the deployment
    def approved = true
    
    // Playbook Execution if approved
    if (approved) {
        ansiblePlaybook(
            inventory: 'aws_ec2.yml',
            playbook: 'pb.yml'
        )
    } else {
        echo "Deployment not approved. Exiting."
    }
}
