import { Button } from "@mui/material";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";

const POSTS = [
    { id: 1, title: "Post 1" },
    { id: 2, title: "Post 2" },
];

function wait(duration: number) {
    return new Promise((resolve) => setTimeout(resolve, duration));
}

const Test = () => {
    const queryClient = useQueryClient()
    const postQuery = useQuery({
        queryKey: ["posts"],
        // queryFn: () => Promise.reject("Error message")
        queryFn: () => wait(1000).then(() => [...POSTS]),
    });

    const newPostMutation = useMutation({
        mutationFn: (title: string) => {
            return wait(1000).then(() => POSTS.push({ id: Math.random(), title }));
        },
        onSuccess: () => queryClient.invalidateQueries({queryKey: ["posts"]})
    });

    if (postQuery.isLoading) {
        return "Loading...";
    }

    if (postQuery.isError) {
        return JSON.stringify(postQuery.error);
    }

    return (
        <>
            {postQuery.data?.map((post) => (
                <div key={post.id}>{post.title}</div>
            ))}
            <Button
            disabled={newPostMutation.isPending} 
             variant="contained" onClick={() => newPostMutation.mutate("New Post")}>
                Add new
            </Button>
            <ReactQueryDevtools />
        </>
    );
};

export default Test;
