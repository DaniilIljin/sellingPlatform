import {UserCredentials} from "../dto/user.ts";
import apiClient from "./apiClient.ts";

export async function login(userCred: UserCredentials) {
    const response = await apiClient.post('/api/login', userCred);
    return response.data;
}