import axios from 'axios'

export const apiClient = axios.create(
    {
        //baseURL: 'http://localhost:5000' //#CHANGE
        baseURL: 'http://todoapph2-env.eba-urb53zjs.ap-southeast-1.elasticbeanstalk.com/'
    }
);

/* For Best Practices https://facebook.github.io/create-react-app/docs/adding-custom-environment-variables*/
