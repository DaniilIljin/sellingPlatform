import { useState, useEffect } from "react";
import { Category } from "../../../dto/Category";

const useFetchCategories = () => {
    const url: string = "http://localhost:8080/api/category/all";
    const [categories, setCategories] = useState<Category[]>([] as Category[]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                const result: Category[] = await response.json();
                setCategories(result);
            } catch (err) {
                setError("Failed to fetch data");
                console.log(err);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, [url]);

    return { categories, loading, error };
};

export default useFetchCategories;
