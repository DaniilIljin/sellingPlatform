import { useEffect, useState } from "react";
import { Item } from "../../dto/Item";

const useFetchItems = () => {
    const url: string = "http://localhost:8080/api/item/all";
    const [items, setItems] = useState<Item[]>([] as Item[]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                const result: Item[] = await response.json();
                setItems(result);
            } catch (err) {
                setError("Failed to fetch data");
                console.log(err);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, [url]);

    return { items, loading, error };
};

export default useFetchItems;
