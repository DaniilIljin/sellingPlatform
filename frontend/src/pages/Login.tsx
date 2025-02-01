import { TextField, Button } from '@mui/material';
import { useForm } from 'react-hook-form';
import {UserCredentials} from "../dto/user.ts";

const LoginForm = () => {
    const { register, handleSubmit, formState: { errors } } = useForm<UserCredentials>();

    const onSubmit = (data: UserCredentials) => {
        console.log('Submitted Data:', data);
    };

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <TextField
                label="Username"
                {...register('username', { required: 'Username is required' })}
                error={!!errors.username}
                helperText={errors.username?.message}
            />
            <br/>
            <TextField
                margin="normal"
                label="Password"
                {...register('password', { required: 'Password is required' })}
                error={!!errors.password}
                helperText={errors.password?.message}
            />
            <br/>
            <Button type="submit" variant="contained" color="primary">
                Login
            </Button>
        </form>
    );
};

export default LoginForm;
