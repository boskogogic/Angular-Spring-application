export const environment = {
    production: false, 
    msalConfig : {
        auth: {
            clientId: 'fbd7a17a-abbf-46fe-a56b-42f868eb9e71',
            authority: 'https://login.microsoftonline.com/fe77c4f9-b540-46fb-b5bd-24c6dc8e1346',
            tenantId: 'fe77c4f9-b540-46fb-b5bd-24c6dc8e1346'
        },
        apiConfig : {
            //api per'api://fa8f1547-974d-4b8b-8f53-abc5833e0d5d/LxApi' User.Read means that we can sign in and read user profile
            scopes: ['api://fbd7a17a-abbf-46fe-a56b-42f868eb9e71/LxAngularApi'],
            url: 'https://graph.microsoft.com/v1.0/me',
            redirectUrl: 'http://localhost:4200'
        }
    },
    applicationConfig : {
        server_url: 'http://localhost:8090/'
    }
};
