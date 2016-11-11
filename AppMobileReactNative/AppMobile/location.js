import React, { Component, PropTypes } from 'react';

import 
{
	 StyleSheet,
	 TouchableOpacity,
     TextInput,
	 Text,
	 View
} 
from 'react-native';

export class Location extends Component
{
    constructor()
    {
        super();

        this.state = {
            location: '',
            description: '',
        };
    }

    render()
    {
        return (
            <View>
            </View>
        )
    }
}