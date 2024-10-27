import axios from 'axios';

// Create an Axios instance
export const apiClient = axios.create({
  baseURL: 'https://your-api-url.com/api', // Replace with your API URL
  timeout: 10000, // Optional: set a timeout for requests
});

// Function to get JWT and refresh token from local storage
const getTokens = () => {
  return {
    accessToken: localStorage.getItem('accessToken'), // Replace with your token storage logic
    refreshToken: localStorage.getItem('refreshToken'),
  };
};

// Set up request interceptor to add JWT
apiClient.interceptors.request.use(
  (config) => {
    const { accessToken } = getTokens();
    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Set up response interceptor to handle token refresh
apiClient.interceptors.response.use(
  (response) => {
    return response;
  },
  async (error) => {
    const originalRequest = error.config;
    const { response } = error;

    // If the error is due to unauthorized access (status 401)
    if (response.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true; // Prevent infinite loop
      const { refreshToken } = getTokens();

      try {
        // Send a request to refresh the token
        const { data } = await axios.post('https://your-api-url.com/api/auth/refresh', { token: refreshToken });

        // Save the new access token
        localStorage.setItem('accessToken', data.accessToken);
        apiClient.defaults.headers.common['Authorization'] = `Bearer ${data.accessToken}`;

        // Retry the original request
        originalRequest.headers['Authorization'] = `Bearer ${data.accessToken}`;
        return apiClient(originalRequest);
      } catch (refreshError) {
        // Handle refresh token error (e.g., redirect to login)
        console.error('Refresh token failed:', refreshError);
        // Optionally show an error message to the user
        return Promise.reject(refreshError);
      }
    }

    // If the error is not a 401 or refresh failed, reject the promise
    return Promise.reject(error);
  }
);
