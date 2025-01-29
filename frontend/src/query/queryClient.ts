import { QueryClient } from '@tanstack/react-query';

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            retry: 2, // Retries failed requests twice before throwing an error
            refetchOnWindowFocus: false, // Disable automatic refetch on window focus
        },
    },
});

export default queryClient;
