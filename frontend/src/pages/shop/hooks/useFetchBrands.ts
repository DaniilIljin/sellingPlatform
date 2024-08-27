import { useState, useEffect } from "react";
import { Brand } from "../../../dto/Brand";

const useFetchBrands = () => {
    const url: string = "http://localhost:8080/api/brand/all";
    const [brands, setBrands] = useState<Brand[]>([] as Brand[]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                const result: Brand[] = await response.json();
                setBrands(result);
            } catch (err) {
                setError("Failed to fetch data");
                console.log(err);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, [url]);

    return { brands, loading, error };
};

export default useFetchBrands;
